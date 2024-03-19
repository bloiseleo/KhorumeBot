package KhorumeBot.Core.Interfaces

/**
 * This interface is the main interface of the principal service: The KhorumeBotImpl.
 *
 * This will define how a class should behave in order to build an instance of a valid running KhorumeBotImpl.
 *
 * @param T: Object that will handle all the Discord REST API and Webservices.
 * @param I: Object that represent an interaction made by an User and listened by the KhorumeBot Listener.
 * @param R: Object that represent an interaction generator to be sent to Discord and become available to users.
 */
interface KhorumeBot<T, I, R> {
    /**
     * Start the bot using the instance given.
     * @param bot: T
     */
    public fun start(bot: T): Unit;
    /**
     * Create and properly prepare an instance of a class that should
     * be able to connect to Discord REST API and Webservices. Besides, It should be
     * able to handle all needs of the running bot.
     *
     * This instance will be passed to start method.
     */
    public fun setup(): T;
    /**
     * Prepare, validate and add all the features of the Modules into the bot running.
     */
    public fun appendModule(module: Set<KhorumeBotModule<I, R>>)
}