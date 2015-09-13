package com.sino.data.redis.query;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.query.SortQuery;

import java.util.List;


public class QueryUtil {

    public static List join(SortQuery sortQuery) {
        /**
         *
         SortQuery query = SortQueryBuilder.sort("ad_person:PERSON_ID").noSort()
         .get("#")
         .get("ad_person:*->LOGIN_NAME")
         .get("ad_person:*->LOGIN_PASSWORD")
         .get("ad_person:*->NAME")
         .get("ad_person:*->CODE")
         .get("ad_person:*->GENDER")
         .get("ad_staff:PERSON_ID:*->STAFF_ID")
         .get("ad_staff:PERSON_ID:*->NAME")
         .get("ad_staff:PERSON_ID:*->STATUS")
         .get("ad_staff:PERSON_ID:*->CREATE_TIME")
         .build();
         */
        return new RedisTemplate<>().sort(sortQuery);
    }

}
