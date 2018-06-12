package com.gu.sfl

import java.time.Instant

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.util.Random

object TaskTesks {

  val r = Random
  private def postBody : String = {
    val add = r.nextBoolean()

    def addArticle: String = {
      if (add) {
        """, {
          |		"id": "law/2018/apr/12/icc-prosecutes-islamist-militant-al-hassan-ag-abdoul-aziz-ag-mohamed-ag-mahmoud-gender-persecution",
          |		"shortUrl": "/p/8degj",
          |		"date": "2018-04-12T13:42:38",
          |		"read": false
          |	}""".stripMargin
      } else ""
    }

    def nextVersion: String = Instant.now().toEpochMilli.toString

    val body: String = s"""{
         |	"version": "${nextVersion}",
         |	"articles": [{
         |		"id": "us-news/2018/apr/20/opioid-crisis-n001-drug-painkiller-solution-lab-san-francisco",
         |		"shortUrl": "/p/8dtge",
         |		"date": "2018-04-20T11:39:21",
         |		"read": false
         |	}, {
         |		"id": "sport/2018/apr/12/tyson-fury-boxing-return-frank-warren",
         |		"shortUrl": "/p/8dmyg",
         |		"date": "2018-04-12T15:38:33",
         |		"read": false
         |	}, {
         |		"id": "film/2018/apr/12/whats-the-secret-to-the-rocks-success",
         |		"shortUrl": "/p/8dty7",
         |		"date": "2018-04-12T15:38:26",
         |		"read": false
         | }
         | ${addArticle}


         |}
         """
       body

    }

    val updateArticlesTask = exec(
      http("UpdateArticlesTasks")
         .post("/syncedPrefs/me")
         .header("content-type", "application/json")
         .body(StringBody(postBody))
         .asJSON
         .check(status is 200)
    )

    val getArticlesTask = exec(
      http("getArticlesTask")
        .get("/syncedPrefs/me")
        .header("content-type", "application/json")
        .asJSON
        .check(status is 200)
    )
}
