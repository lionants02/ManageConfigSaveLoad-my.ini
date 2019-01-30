import java.io.File
import java.nio.file.Files

val myIni = Files.lines(File("src/test/resources/my.ini").toPath())
val myHuge = Files.lines(File("src/test/resources/my-huge.ini").toPath())
val mySmall = Files.lines(File("src/test/resources/my-small.ini").toPath())

