package com.hirocode.tmdb

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hirocode.tmdb.domain.model.Movies
import org.koin.androidx.compose.koinViewModel

@Composable
fun TmdbApp(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text(stringResource(id = R.string.app_name)) }
            )
        }
    ) {
        MainScreen(
            modifier = modifier.padding(it)
        )
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = koinViewModel()
) {
    val mainState by viewModel.mainState.collectAsState()
    when(mainState) {
        MainState.Loading -> {
            LoadingScreen(modifier)
        }
        is MainState.Error -> {
            val error = (mainState as MainState.Error).message
            ErrorScreen(error, modifier)
        }
        is MainState.Success -> {
            val movies = (mainState as MainState.Success).data
            PopularList(movies, modifier)
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen(
    error: String,
    modifier: Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(error)
    }
}

@Composable
fun PopularList(
    movies: List<Movies>,
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(movies) { movies ->
            PopularItem(movies)
        }
    }
}

@Composable
fun PopularItem(movies: Movies) {
    Row {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500" + movies.posterPath,
            contentDescription = movies.title,
            modifier = Modifier
                .width(100.dp)
                .height(130.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop,
        )
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
            Text(
                text = movies.title,
                modifier = Modifier.padding(bottom = 8.dp),
                color = MaterialTheme.colors.onSurface,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
            Text(
                text = movies.overview,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                fontSize = 14.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 3
            )
        }
    }
}
