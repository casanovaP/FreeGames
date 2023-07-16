package com.example.freegames.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.freegames.R
import com.example.freegames.domain.model.Game
import com.example.freegames.navigation.Screen
import com.example.freegames.utils.Constants.BASE_URL

@Composable
fun GameItem(
    game: Game,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { navController.navigate(Screen.Details.passGameId(gameId = game.id)) }
    ) {
        Column(
            Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                modifier = Modifier.size(300.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = "$BASE_URL${game.thumbnail}")
                    .placeholder(drawableResId = R.drawable.baseline_downloading_24)
                    .error(drawableResId = R.drawable.baseline_error_outline_24)
                    .build(),
                contentDescription = stringResource(R.string.game_image),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = game.title,
                style = TextStyle(fontSize = 18.sp),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = game.genre)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = game.platform)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = game.releaseDate)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameItemPreview() {
    GameItem(
        game = Game(
            id = 1,
            title = "Atlantica",
            developer = "EA",
            freeToGameProfileUrl = "www.,,sfdksdfjsj",
            gameUrl = "more ofthesame",
            genre = "action",
            platform = "pc and ps",
            publisher = "Nexus",
            releaseDate = "01.02.0.225",
            shortDescription = "hsdgjklödsaalsf,aperitixsdfm dsmfsdfsoritzksdf klsfcölaskd",
            thumbnail = "your advertisement here"
        ),
        navController = rememberNavController()
    )
}