//الكتاب مش كتاب تتعلم منه اوبجكت اوريتد ده كتاب تتعلم منه الديزاين
import java.util.Timer
import java.util.TimerTask

data class DogDoor(var open: Boolean = false, private var allowedBarks: MutableList<Bark> =mutableListOf<Bark>())
{
    fun addAllowedBark(newBark:Bark){ allowedBarks +=newBark }
    fun getAllowedBarks()=allowedBarks
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
        open = false
        println("the door is close ! ")
    }
}
//BarkRecognizer
data class BarkRecognizer(private val dogDoor: DogDoor){
    fun recognize(bark: Bark){
        dogDoor.getAllowedBarks().forEach {
            if(it==bark){
                println("Found Voice ${bark.sound}")
                dogDoor.open()
                return } }} }
//Bark => نباح
data class Bark(val sound: String, )
fun Do() {
    val dogDoor = DogDoor()
    val recognizer = BarkRecognizer(dogDoor)
    dogDoor.addAllowedBark(Bark("صوت نباح الكلب"))
    dogDoor.addAllowedBark(Bark("صوت نباح الكلب"))
    recognizer.recognize(Bark("صوت نباح الكلب"))
}