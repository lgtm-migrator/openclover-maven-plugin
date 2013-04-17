package com.atlassian.maven.plugin.clover.internal.instrumentation;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import com.atlassian.maven.plugin.clover.internal.scanner.CloverSourceScanner;
import com.atlassian.maven.plugin.clover.internal.scanner.MainSourceScanner;
import com.atlassian.maven.plugin.clover.internal.CompilerConfiguration;

import java.util.List;

/**
 * Instruments main sources.
 */
public class MainInstrumenter extends AbstractInstrumenter {
    private final MainSourceScanner scanner;

    public MainInstrumenter(final CompilerConfiguration configuration, final String outputSourceDirectory) {
        super(configuration, outputSourceDirectory);
        scanner = new MainSourceScanner(configuration, outputSourceDirectory);
    }

    protected CloverSourceScanner getSourceScanner() {
        return scanner;
    }

    protected String getSourceDirectory() {
        return getConfiguration().getProject().getBuild().getSourceDirectory();
    }

    protected void setSourceDirectory(final String targetDirectory) {
        getConfiguration().getProject().getBuild().setSourceDirectory(targetDirectory);
    }

    protected List<String> getCompileSourceRoots() {
        return getConfiguration().getProject().getCompileSourceRoots();
    }

    protected void addCompileSourceRoot(final String sourceRoot) {
        getConfiguration().getProject().addCompileSourceRoot(sourceRoot);
    }
}
