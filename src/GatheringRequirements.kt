import java.util.Timer
import java.util.TimerTask

data class DogDoor(var open: Boolean = false) {
    fun open() {
        open = true;println("the door is open ! ")
    }

    fun close() {
        open = false; println("the door is close ! ")
    }
}

data class Remote(val dogDoor: DogDoor) {
    //    fun open(){ dogDoor.open() }
//    fun close(){ dogDoor.close() }

    fun pressButton() {
        if (dogDoor.open) dogDoor.close()
        else dogDoor.open()

        val timer = Timer()

        val timerTask = object : TimerTask() {
            override fun run() {
                dogDoor.close()
                timer.cancel()
            }
        }
        timer.schedule(timerTask, 5000)
    }
}

