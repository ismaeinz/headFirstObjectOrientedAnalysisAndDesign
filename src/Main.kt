//الكتاب مش كتاب تتعلم منه اوبجكت اوريتد ده كتاب تتعلم منه الديزاين
import java.util.Timer
import java.util.TimerTask

data class DogDoor(var open: Boolean = false) {
    fun open() {
        open = true
        println("the door is open ! ")
        val timer = Timer()
        val timerTask = object : TimerTask() {
            override fun run() {
            close()
            }
        }
        timer.schedule(timerTask, 5000)
    }

    fun close() {
        open = false; println("the door is close ! ")
    }
}

data class Remote(val dogDoor: DogDoor) {
    fun pressButton() {
        if (dogDoor.open) dogDoor.close()
        else dogDoor.open()
    }
}
//BarkRecognizer
data class BarkRecognizer(private val door: DogDoor){
    fun recognize(bark: String){
        println("Found Voice $bark")
        door.open()
    }
}

fun main() {
    val dogDoor = DogDoor()
    val recognizer = BarkRecognizer(dogDoor)
    recognizer.recognize("هو هو ")
} 