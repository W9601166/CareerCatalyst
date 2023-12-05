import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uk.ac.tees.w9601166.careercatalyst.ui.data.model.Category
import uk.ac.tees.w9601166.careercatalyst.ui.data.model.Job
import uk.ac.tees.w9601166.careercatalyst.ui.data.model.Room

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobCard(item: Job, position: Int) {

    Card(elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White , contentColor = Color.Black),
        modifier = Modifier
            .background(
                Color.White,
                    RoundedCornerShape(
                        topStart = 24.dp,
                        topEnd = 24.dp,
                        bottomEnd = 24.dp,
                        bottomStart = 0.dp
                    )
            )
            .fillMaxHeight(.40F)
            .fillMaxWidth(.5F)


    ) {
        Column(
            modifier = Modifier
                .width(200.dp)
                .height(182.dp)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(),
                textAlign = TextAlign.Justify,
                text = "Job Title : "+ item.jobTitle + "\n" + item.jobDescription,
                style = TextStyle( fontSize = 20.sp),
            )
        }
    }
}