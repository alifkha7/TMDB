# Movies Feature Specs
# BDD Specs
# Story: Customer requests to see popular movies list
### Narrative #1
```
As an online customer
I want the app to automatically load popular movies list
So I can always enjoy the newest load popular movies list
```
#### Scenarios (Acceptance criteria)
```
Given the customer has connectivity
When the customer requests to see popular movies list
Then the app should display the latest popular movies list from remote
```
### Narrative #2
```
As an offline customer
```
#### Scenarios (Acceptance criteria)
```
Given the customer doesn't have connectivity
When the customer requests to see the popular movies list
Then the app should display an error message
```
# Flowchart
<picture>
  <img alt="Flowchart" src="https://github.com/alifkha7/Tmdb/blob/master/Flowchart.png">
</picture>

# App Architecture
# Payload contract
```
GET /movie/popular

200 RESPONSE

{
  "page": 1,
  "results": [
    {
      "poster_path": "/e1mjopzAS2KNsvpbpahQ1a6SkSn.jpg",
      "adult": false,
      "overview": "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.",
      "release_date": "2016-08-03",
      "genre_ids": [
        14,
        28,
        80
      ],
      "id": 297761,
      "original_title": "Suicide Squad",
      "original_language": "en",
      "title": "Suicide Squad",
      "backdrop_path": "/ndlQ2Cuc3cjTL7lTynw6I4boP4S.jpg",
      "popularity": 48.261451,
      "vote_count": 1466,
      "video": false,
      "vote_average": 5.91
    }
  ],
  "total_results": 19629,
  "total_pages": 982
}

401 RESPONSE

{
  "status_message": "Invalid API key: You must be granted a valid key.",
  "success": false,
  "status_code": 7
}

404 RESPONSE

{
  "status_message": "The resource you requested could not be found.",
  "status_code": 34
}
```
