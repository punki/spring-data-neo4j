/**
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.neo4j.support.index;

import org.neo4j.graphdb.index.IndexManager;
import org.neo4j.helpers.collection.MapUtil;
import org.neo4j.index.impl.lucene.LuceneIndexImplementation;

import java.util.Map;

public enum IndexType
{   
    SIMPLE{ public Map<String,String> getConfig() { return LuceneIndexImplementation.EXACT_CONFIG; } },
    FULLTEXT { public Map<String,String> getConfig() { return LuceneIndexImplementation.FULLTEXT_CONFIG; } },
    POINT { public Map<String,String> getConfig() { return MapUtil.stringMap(
            IndexManager.PROVIDER, "spatial", "geometry_type" , "point","wkt","wkt") ; } };
    public abstract Map<String, String>getConfig();
}
