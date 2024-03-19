package KhorumeBot.Core.Errors

class TokenNotFound(): RuntimeException("Environment variable DISCORD_TOKEN must be set with discord API token") {}