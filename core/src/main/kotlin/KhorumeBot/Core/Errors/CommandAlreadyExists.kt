package KhorumeBot.Core.Errors

class CommandAlreadyExists(commandName: String): RuntimeException("$commandName already exists") { }