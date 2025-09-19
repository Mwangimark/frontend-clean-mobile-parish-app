package com.example.parishmobileapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parishmobileapp.R


@Composable
fun RegisterScreen(
    onNavigateToLogin: () -> Unit,
    onGoogleSignIn: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        // Header image (place a drawable named login_header.jpg/png in res/drawable)
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Welcome",
            modifier = Modifier
                .height(150.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "St. Francis Xavier Parklands Catholic Church",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ),
            color = MaterialTheme.colorScheme.primary
        )

        // Form card for a clean elevated look
        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Create account", style = MaterialTheme.typography.headlineSmall)

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = name, onValueChange = { name = it },
                    label = { Text("Full name") }, modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = email, onValueChange = { email = it },
                    label = { Text("Email") }, modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = password, onValueChange = { password = it },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = confirmPassword, onValueChange = { confirmPassword = it },
                    label = { Text("Confirm password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        /* local validation / call register endpoint later */
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Register")
                }

                Spacer(modifier = Modifier.height(12.dp))

               Row(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.SpaceEvenly
               ){
                   Image(painter = painterResource(id = R.drawable.fb), contentDescription = "facebook",
                       modifier = Modifier.size(50.dp).clickable{
                           //facebook clickable
                       })

                   Image(painter = painterResource(id = R.drawable.google_logo), contentDescription = "google",
                       modifier = Modifier.size(68.dp).clickable{
                           //google clickable
                       })

                   Image(painter = painterResource(id = R.drawable.twitter), contentDescription = "twitter",
                       modifier = Modifier.size(68.dp).clickable{
                       })
               }

            }

        }

        TextButton(onClick = onNavigateToLogin) {
            Text("Already have an account? Log in")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    // pass empty lambdas for preview
    RegisterScreen(onNavigateToLogin = {}, onGoogleSignIn = {})
}
