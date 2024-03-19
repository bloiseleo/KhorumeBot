package KhorumeBot.Core.Implementations.Javacord

import KhorumeBot.Core.Errors.CommandAlreadyExists
import KhorumeBot.Core.Errors.TokenNotFound
import KhorumeBot.Core.Interfaces.DiscordCommand
import KhorumeBot.Core.Interfaces.KhorumeBot
import KhorumeBot.Core.Interfaces.KhorumeBotModule
import org.javacord.api.DiscordApi
import org.javacord.api.DiscordApiBuilder
import org.javacord.api.entity.intent.Intent
import org.javacord.api.interaction.SlashCommandBuilder
import org.javacord.api.interaction.SlashCommandInteraction

class KhorumeBotImpl: KhorumeBot<DiscordApi, SlashCommandInteraction , SlashCommandBuilder>  {
    private val modules: MutableSet<KhorumeBotModule<SlashCommandInteraction, SlashCommandBuilder>> = HashSet()
    private val handlers: MutableMap<String, DiscordCommand<SlashCommandInteraction, SlashCommandBuilder>> = HashMap()
    companion object {
        fun start(module: Set<KhorumeBotModule<SlashCommandInteraction, SlashCommandBuilder>>) {
            val bot = KhorumeBotImpl()
            bot.appendModule(module)
            val discordAPI = bot.setup()
            bot.start(discordAPI)
        }
    }
    override fun start(bot: DiscordApi) {
        modules.stream().forEach {
            val commands =  it.commands()
            commands.entries.forEach { command ->
                val slashCommandBuilder = command.value.Build()
                if(handlers.containsKey(command.value.name)) {
                    throw CommandAlreadyExists(command.value.name)
                }
                handlers[command.value.name] = command.value
                slashCommandBuilder
                        .createGlobal(bot)
                        .join()
            }
        }
        bot.addSlashCommandCreateListener {
            it.slashCommandInteraction
                    .createImmediateResponder()
                    .append("Hello!")
                    .respond()
        }
    }
    override fun setup(): DiscordApi {
        val token = System.getenv("DISCORD_TOKEN") ?: throw TokenNotFound()
        return DiscordApiBuilder()
                .setWaitForServersOnStartup(false)
                .setWaitForUsersOnStartup(false)
                .setToken(token)
                .addIntents(Intent.MESSAGE_CONTENT)
                .login().join()
    }
    override fun appendModule(module: Set<KhorumeBotModule<SlashCommandInteraction, SlashCommandBuilder>>) {
        modules.addAll(module)
    }
}