package read.config.mysql

internal class ConfigMachine {
    private val rexWord = Regex("""^\w.*""")

    fun process(firstChar: String): Stage {
        return when {
            firstChar.startsWith('#') -> Stage.NextLine
            firstChar.startsWith(';') -> Stage.NextLine
            firstChar.startsWith('[') -> Stage.GetGroup
            rexWord.matches(firstChar) -> Stage.GetOpt
            else -> Stage.NextLine
        }
    }

    internal enum class Stage {
        NextLine, GetGroup, GetOpt
    }
}
