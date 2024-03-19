package KhorumeBot.Core.Implementations

import KhorumeBot.Core.Interfaces.KhorumeBot
import KhorumeBot.Core.Interfaces.KhorumeBotModule
import org.javacord.api.DiscordApi
import org.javacord.api.interaction.SlashCommand
import org.javacord.api.interaction.SlashCommandInteraction

class KhorumeBotImpl: KhorumeBot<DiscordApi, SlashCommand, SlashCommandInteraction>  {
    override fun start(bot: DiscordApi) {
        TODO("Not yet implemented")
    }

    override fun setup(): DiscordApi {
        TODO("Not yet implemented")
    }

    override fun appendModule(module: Set<KhorumeBotModule<SlashCommand, SlashCommandInteraction>>) {
        TODO("Not yet implemented")
    }

}