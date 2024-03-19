package KhorumeBot.Core.Interfaces

interface KhorumeBotModule<I, R> {
    /**
     * A Hash Map containing all the DiscordCommands being pointed by its name.
     * The name must be unique, because it will be used as a key to the object responsible to handle it.
     */
    public fun commands(): HashMap<String, DiscordCommand<I, R>>;
}