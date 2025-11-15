package com.example.parishmobileapp.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    onProfileClick: () -> Unit = {},
    onCardClick: (String) -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("ST FRANCIS XAVIER PARKLANDS", fontWeight = FontWeight.Bold) },
                actions = {
                    IconButton(onClick = onProfileClick) {
                        Icon(Icons.Default.AccountCircle, contentDescription = "Profile")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(selected = true, onClick = {}, icon = { Icon(Icons.Default.Home, contentDescription = "Home") }, label = { Text("Home") })
                NavigationBarItem(selected = false, onClick = {}, icon = { Icon(Icons.Default.DateRange, contentDescription = "Events") }, label = { Text("Events") })
                NavigationBarItem(selected = false, onClick = {}, icon = { Icon(Icons.Default.Notifications, contentDescription = "Announcements") }, label = { Text("Announcements") })
                NavigationBarItem(selected = false, onClick = {}, icon = { Icon(Icons.Default.Info, contentDescription = "More Info") }, label = { Text("More Info") })
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Welcome + Verse
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    "Welcome, Mark",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "“If we live, it’s to honor the Lord...”",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Quick Actions
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ActionCard("Giving", Icons.Default.Create, modifier = Modifier.weight(1f)) { onCardClick("Giving") }
                    ActionCard("Announcements", Icons.Default.Notifications, modifier = Modifier.weight(1f)) { onCardClick("Announcements") }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ActionCard("Daily Readings", Icons.Default.AccountBox, modifier = Modifier.weight(1f)) { onCardClick("Daily Readings") }
                    ActionCard("Common Prayers", Icons.Default.Favorite, modifier = Modifier.weight(1f)) { onCardClick("Common Prayers") }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // About Parish
                ActionCard("About St. Francis Xavier", Icons.Default.Info, modifier = Modifier.fillMaxWidth()) { onCardClick("About") }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Upcoming Events (Horizontal Scroll)
            Text("Upcoming Events", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                HighlightCard("Youth Retreat", "Nov 20")
                HighlightCard("Sunday Mass", "Nov 21")
                HighlightCard("Charity Drive", "Nov 25")
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@Composable
fun ActionCard(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(120.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(icon, contentDescription = title, modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(title, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun HighlightCard(title: String, date: String) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(100.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(title, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(date, fontWeight = FontWeight.Normal)
        }
    }
}
