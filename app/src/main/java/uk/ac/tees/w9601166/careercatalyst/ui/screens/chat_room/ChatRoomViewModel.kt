package uk.ac.tees.w9601166.careercatalyst.ui.screens.chat_room

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import uk.ac.tees.w9601166.careercatalyst.ui.data.database.addMessageToRoomFireStore
import uk.ac.tees.w9601166.careercatalyst.ui.data.database.getMessage
import uk.ac.tees.w9601166.careercatalyst.ui.data.database.getMessageCollection
import uk.ac.tees.w9601166.careercatalyst.ui.data.model.Message
import uk.ac.tees.w9601166.careercatalyst.ui.data.model.Room
import uk.ac.tees.w9601166.careercatalyst.ui.session.SessionProvider
import com.google.firebase.firestore.DocumentChange

class ChatRoomViewModel : ViewModel() {
    val messageFieldState = mutableStateOf("")
    val newMessageState = mutableStateOf<List<Message>>(emptyList())


    var room: Room? = null
    fun addMessageToFireStore() {
        if(messageFieldState.value.isEmpty() || messageFieldState.value.isBlank()) return
        val message = Message(
            content = messageFieldState.value,
            senderId = SessionProvider.user?.id,
            senderName = SessionProvider.user?.firstName,
            roomId = room?.id ?: ""
        )
        addMessageToRoomFireStore(message) {
            if (it.isSuccessful) {
                messageFieldState.value = ""

                return@addMessageToRoomFireStore
            }
                Log.e("message", "cant Send Message")

        }
    }


    fun listenForMessageInRoom(){
      getMessage(roomId = room?.id ?: "") {snapShot, error ->
          val newMessage = mutableListOf<Message>()
           snapShot?.documentChanges?.forEach { docChange ->
               when (docChange.type) {
                   DocumentChange.Type.ADDED -> {
                       val message = docChange.document.toObject(Message::class.java)
                       newMessage.add(message)
                   }
                   DocumentChange.Type.MODIFIED -> {

                   }
                   DocumentChange.Type.REMOVED -> {

                   }
               }
           }
          val newList = mutableListOf<Message>()
          newList.addAll(newMessage) // add new messages
          newList.addAll(newMessageState.value) // add old messages
          newMessageState.value = newList

          }

    }
}