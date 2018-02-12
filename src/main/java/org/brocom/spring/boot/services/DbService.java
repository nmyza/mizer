package org.brocom.spring.boot.services;

import com.couchbase.client.java.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {

    private @Autowired Bucket bucket;


}
