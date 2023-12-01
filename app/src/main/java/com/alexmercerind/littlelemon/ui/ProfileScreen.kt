package com.alexmercerind.littlelemon.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.alexmercerind.littlelemon.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    val userViewModel = viewModel<UserViewModel>()

    val firstName by userViewModel.firstName.collectAsState()
    val lastName by userViewModel.lastName.collectAsState()
    val email by userViewModel.email.collectAsState()

    val scroll = rememberScrollState()
    val scope = rememberCoroutineScope()


    Scaffold(topBar = { PrimaryTopAppBar(navController) }) { padding ->
        Column(
            modifier = Modifier
                .heightIn(540.dp, (1 shl 16).dp)
                .fillMaxHeight()
                .padding(padding)
                .padding(horizontal = 16.dp)
                .verticalScroll(scroll)
                .imePadding(),
        ) {
            Spacer(modifier = Modifier.weight(1.0F))

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = stringResource(id = R.string.personal_information_title),
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = stringResource(id = R.string.personal_information_first_name),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                readOnly = true,
                value = firstName,
                onValueChange = { },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Text
                ),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))


            Text(
                text = stringResource(id = R.string.personal_information_last_name),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                readOnly = true,
                value = lastName,
                onValueChange = { },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Text
                ),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(id = R.string.personal_information_email_name),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                readOnly = true,
                value = email,
                onValueChange = { },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Email
                ),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Spacer(modifier = Modifier.weight(2.0F))


            PrimaryButton(
                text = R.string.log_out,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                scope.launch {
                    userViewModel.clear()

                    navController.navigate(Onboarding.route)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
