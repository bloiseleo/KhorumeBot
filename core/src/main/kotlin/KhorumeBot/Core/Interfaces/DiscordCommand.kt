package KhorumeBot.Core.Interfaces

/**
 * Base interface that any KhorumeBot Module will expose its commands through.
 */
interface DiscordCommand<I, R> {
    val name: String
        get() { throw  NotImplementedError() }
    /**
     * Respond to a given DiscordCommand, which is, in turn, a basic SlashCommand.
     * @param interaction: SlashCommandInteraction
     */
    fun Respond(interaction: I)
    /**
     * Build any kind of SlashCommand
     * @return slashCommand: SlashCommand;
     */
    fun Build(): R
}