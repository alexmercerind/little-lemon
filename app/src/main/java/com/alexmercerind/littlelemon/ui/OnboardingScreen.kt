package com.alexmercerind.littlelemon.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.alexmercerind.littlelemon.R
import com.alexmercerind.littlelemon.ui.theme.PrimaryColor0
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingScreen(navController: NavController) {
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }

    val scroll = rememberScrollState()
    val scope = rememberCoroutineScope()

    val userViewModel = viewModel<UserViewModel>()

    var success by rememberSaveable { mutableStateOf(false) }
    var fail by rememberSaveable { mutableStateOf(false) }

    Scaffold(topBar = { PrimaryTopAppBar(navController) }) { padding ->
        Column(
            modifier = Modifier
                .heightIn(540.dp, (1 shl 16).dp)
                .fillMaxHeight()
                .padding(padding)
                .verticalScroll(scroll)
                .imePadding(),
        ) {
            Surface(
                color = PrimaryColor0, modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.onboarding_headline),
                    style = MaterialTheme.typography.headlineMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.wrapContentSize(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = stringResource(id = R.string.personal_information_title),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = stringResource(id = R.string.personal_information_first_name),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))


            Text(
                text = stringResource(id = R.string.personal_information_last_name),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(id = R.string.personal_information_email_name),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Spacer(modifier = Modifier.weight(2.0F))


            PrimaryButton(
                text = R.string.register,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                scope.launch {
                    if (firstName.isNotBlank() && lastName.isNotBlank() && email.isNotBlank()) {
                        success = true
                        userViewModel.save(firstName, lastName, email)
                    } else {
                        fail = true
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }

    if (fail) {
        AlertDialog(
            onDismissRequest = { fail = false },
            confirmButton = {
                TextButton(
                    onClick = { fail = false }
                ) {
                    Text(text = stringResource(id = R.string.ok))
                }
            },
            text = { Text(text = stringResource(id = R.string.registration_fail)) }
        )
    }

    if (success) {
        AlertDialog(
            onDismissRequest = { navController.navigate(Home.route) },
            confirmButton = {
                TextButton(
                    onClick = { navController.navigate(Home.route) }
                ) {
                    Text(text = stringResource(id = R.string.ok))
                }
            },
            text = { Text(text = stringResource(id = R.string.registration_success)) }
        )
    }
}
