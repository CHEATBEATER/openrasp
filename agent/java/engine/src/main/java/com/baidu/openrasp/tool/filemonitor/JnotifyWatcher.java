/*
 * Copyright 2017-2019 Baidu Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.baidu.openrasp.tool.filemonitor;

import com.baidu.openrasp.messaging.ErrorType;
import com.baidu.openrasp.messaging.LogTool;
import com.fuxi.javaagent.contentobjects.jnotify.Observer;
import org.apache.log4j.Logger;

/**
 * 　　* @Description: 监测并收集jnotify的内部错误，写入rasp.log
 * 　　* @author anyang
 * 　　* @date 2018/5/14 11:12
 */
public class JnotifyWatcher implements Observer {

    private static final Logger LOGGER = Logger.getLogger(JnotifyWatcher.class.getName());
    public String message;

    @Override
    public void update(String s) {
        this.message = s;
        LogTool.error(ErrorType.FSWATCH_ERROR, "JNotify encounters an internal error: " + s);
    }
}
