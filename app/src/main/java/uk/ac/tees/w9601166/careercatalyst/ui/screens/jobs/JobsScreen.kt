package uk.ac.tees.w9601166.careercatalyst.ui.screens.jobs

import JobCard
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import uk.ac.tees.w9601166.careercatalyst.R
import uk.ac.tees.w9601166.careercatalyst.ui.components.ChatAppBar
import uk.ac.tees.w9601166.careercatalyst.ui.navigation.ChatScreens


@Composable
fun JobsScreen(navController: NavHostController, viewModel: JobsViewModel) {
    JobsContent(viewModel,navController = navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobsContent(viewModel: JobsViewModel, navController: NavHostController) {

    Scaffold(
        topBar = {
                 ChatAppBar(topAppTitle = "Jobs", actions = {
                     IconButton(onClick = {
                         viewModel.fetchJobs()
                         navController.popBackStack()
                         navController.navigate(ChatScreens.HomeScreen.name)
                     }) {
                         Icon(tint = Color.White,
                             modifier = Modifier.size(32.dp),
                             painter = painterResource(id = R.drawable.ic_back),
                             contentDescription = "Back to Home"
                         )
                     }
                 })
        },bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = {
                        navController.navigate(ChatScreens.ReedsJobs.name)

                    }) {
                        Icon(painter = painterResource(id = R.drawable.baseline_work_24), contentDescription = "Localized description")
                    }
                    /* IconButton(onClick = { *//* do something *//* }) {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = "Localized description",
                        )
                    }*/
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {  navController.navigate(ChatScreens.AddRoomScreen.name)  },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Add, "Localized description")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.background_pattern),
                    contentScale = ContentScale.FillBounds
                )
                .padding(top = it.calculateTopPadding())
        ) {
            LazyVerticalStaggeredGrid(
                modifier = Modifier.fillMaxSize(),
                columns = StaggeredGridCells.Fixed(2),
                contentPadding = PaddingValues(24.dp),
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalItemSpacing = 24.dp
            ) {

                viewModel._jobss.value?.let { it1 ->
                    items(it1.size) { itemPosition ->
                        val job = viewModel._jobss.value!![itemPosition]
                        JobCard(item = job, position = itemPosition)
                    }
                }
            }
        }

    }
}








