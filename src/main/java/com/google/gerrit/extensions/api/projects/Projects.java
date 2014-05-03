// Copyright (C) 2013 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.gerrit.extensions.api.projects;

import com.google.gerrit.extensions.common.ProjectInfo;
import com.google.gerrit.extensions.restapi.NotImplementedException;
import com.google.gerrit.extensions.restapi.RestApiException;

import java.util.List;

public interface Projects {
  ProjectApi name(String name) throws RestApiException;

  List<ProjectInfo> list() throws RestApiException;
  List<ProjectInfo> list(ListParameter listParameter) throws RestApiException;

  public class ListParameter {
    private boolean description;
    private String prefix;
    private int limit;
    private int start;

    public ListParameter() {}

    public ListParameter(String prefix) {
      this.prefix = prefix;
    }

    public ListParameter withDescription(boolean description) {
      this.description = description;
      return this;
    }

    public ListParameter withPrefix(String prefix) {
      this.prefix = prefix;
      return this;
    }

    public ListParameter withLimit(int limit) {
      this.limit = limit;
      return this;
    }

    public ListParameter withStart(int start) {
      this.start = start;
      return this;
    }

    public boolean getDescription() {
      return description;
    }

    public String getPrefix() {
      return prefix;
    }

    public int getLimit() {
      return limit;
    }

    public int getStart() {
      return start;
    }
  }

  /**
   * A default implementation which allows source compatibility
   * when adding new methods to the interface.
   **/
  public class NotImplemented implements Projects {
    @Override
    public ProjectApi name(String name) throws RestApiException {
      throw new NotImplementedException();
    }

    @Override
    public List<ProjectInfo> list() throws RestApiException {
      throw new NotImplementedException();
    }

    @Override
    public List<ProjectInfo> list(ListParameter listParameter) throws RestApiException {
      throw new NotImplementedException();
    }
  }
}
