/*
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 */

package org.apache.plc4x.java.s7.netty.model.types;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cgarcia
 */
public enum QueryType {
    
    BYALARMTYPE("BYALARMTYPE", (byte) 0x01),
    BYEVENTID("BYEVENTID", (byte) 0x02),
    NONE("NONE", (byte) 0x00);
    
    
    private static final Map<Byte, QueryType> map;
    
    static {
        map = new HashMap<>();
        for (QueryType  subevent : QueryType .values()) {
            map.put(subevent.code, subevent);
        }
    }    
    
    private final String event;
    private final byte code;
    
    QueryType(String event, byte code){
        this.event = event;
        this.code = code;
    }
    
    public String getEvent(){
        return event;
    }    
    
    public byte getCode() {
        return code;
    }    
    
    public static QueryType  valueOfEvent(String event) {
        for (QueryType  value : QueryType .values()) {
            if(value.getEvent().equals(event)) {
                return value;
            }
        }
        return null;
    }

    public static QueryType  valueOf(byte code) {
        return map.get(code);
    }    
}