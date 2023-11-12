import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import uk.ac.tees.w9601166.careercatalyst.ui.screens.login.LoginViewModel

@Composable
fun ChatAlertDialog(
    onDismissRequest: () -> Unit = {} ,
    alertMessage :  @Composable () -> Unit= {},
    dismissButton: @Composable() (() -> Unit)?,
    confirmButton: @Composable () -> Unit
    ) {
        AlertDialog(
            onDismissRequest =  onDismissRequest ,
            confirmButton = confirmButton,
            dismissButton= dismissButton,
            text = alertMessage ,
            modifier = Modifier.fillMaxWidth()
        )
}

