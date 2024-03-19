package KhorumeBot.Core.Interfaces

/**
 * Base interface that any KhorumeBot Module will expose its commands through.
 */
interface DiscordCommand<I, R> {
    /**
     * Respond to a given DiscordCommand, which is, in turn, a basic SlashCommand.
     * @param interaction: SlashCommandInteraction
     */
    public fun Respond(interaction: I): Unit;
    /**
     * Build any kind of SlashCommand
     * @return slashCommand: SlashCommand;
     */
    public fun Build(): R;
}