package com.example.superheroes

import SuperheroesTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize()
            ){
                SuperHero()
            }

        }
    }
}
@Preview
@Composable
fun SuperHero() {
    SuperheroesTheme{
        Column(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
        ) {
            AppTitle()
            LazyColumn {
                items(HeroesRepository.heroes) {
                    SuperHeroItem(hero = it)
                }
            }
        }
    }



}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTitle(){
    CenterAlignedTopAppBar(
        title =  {
            Row(
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,

                ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier.size(64.dp)
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    )
}


@Composable
fun SuperHeroItem(
    hero: Hero
) {

            Card(
                elevation = CardDefaults.cardElevation(2.dp),

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

            ){
                Row (
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,

                ){
                    SuperHeroInfo(modifier = Modifier.weight(0.8f),hero.nameRes,hero.descriptionRes)
                    Spacer(modifier = Modifier.size(16.dp))
                    SuperHeroIcon(hero.imageRes)
                }
            }


}
@Composable
fun SuperHeroInfo(
    modifier: Modifier,
    @StringRes name: Int,
    @StringRes description: Int
){
    Column(
        modifier = modifier

    ) {
        Text(
            text = stringResource(name),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold

        )
        Text(
            text = stringResource(description),
            style = MaterialTheme.typography.bodyLarge
        )
    }

}

@Composable
fun SuperHeroIcon(
    @DrawableRes icon: Int
){
    Card(
        modifier = Modifier.size(72.dp)
    ){
        Image(
            painter = painterResource(icon),
            contentDescription = null,

            contentScale = ContentScale.Crop

        )
    }
}



