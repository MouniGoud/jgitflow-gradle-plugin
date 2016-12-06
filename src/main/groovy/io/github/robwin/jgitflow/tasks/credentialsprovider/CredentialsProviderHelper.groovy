/*
 *
 *  Copyright 2016 Robert Winkler
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */
package io.github.robwin.jgitflow.tasks.credentialsprovider

import com.atlassian.jgitflow.core.JGitFlowReporter
import com.google.common.base.Strings
import org.eclipse.jgit.transport.CredentialsProvider
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider
import org.gradle.api.Project

class CredentialsProviderHelper {
    public static void setupCredentialProvider(Project project) {
        if (project.hasProperty('gitUsername') && project.hasProperty('gitPassword')) {
            String username = project.property("gitUsername")
            String password = project.property("gitPassword")
            if (!Strings.isNullOrEmpty(username) && !Strings.isNullOrEmpty(password)) {
                JGitFlowReporter.get().debugText(getClass().getSimpleName(), "using provided username and password");
                CredentialsProvider.setDefault(new UsernamePasswordCredentialsProvider(username, password));
            }
        }
    }
}