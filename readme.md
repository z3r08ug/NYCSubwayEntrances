![Rip Road Logo](https://fileshare.riproad.com/riproad-logo-sm.png)
# NYC Subway Entrances Project
---


### ➠ The Ask
- Create an `Activity` (Java or Kotlin) called `SubwayEntrances` in the provided Android Studio project *(details below)*<br/><br/>

- The purpose of this activity is to show the full list of NYC Subway Entrances to the user. For each subway entrance, following information should be visible to the user:
    - Name of the station
    - Coordinates (Latitude and Longitude)
    - Lines available at the station. For example: `2, 3, A, C, J`<br/><br/>

- User should have the ability to filter the list by specific line provided at the station. Example: click on `2` to only see the stations that support line 2<br/><br/>

- **UI styles, colors and look/feel of the app is NOT important. The purpose of this exercise is to demonstrate how large chunk of data is processed and utilized while providing a good performance of the application.**<br/><br/>

- The `drawable` folder within the project contains an example of what this screen could look like - see `screen_example.jpg` file. **Please note that you do not have to use this layout. Any layout that meets the requirements listed above will be accepted.**<br/><br/>

- Execute the endpoint below to get the list of all possible subway entrances.
    - URL: `https://ds-test.riproad.com/RRUtils/subwayEntrances/nyc`
    - HTTP Method: `POST`
    - Body (`json`):
        - `timestamp` — the value of this parameter must be the current timestamp in milliseconds
        - Exmaple:
            ```json
            {
                "timestamp": 1604466000000
            }
            ```

- An example of endpoint response body is shown here, where the
    - `NAME` is `index` of `10` and
    - `LINE` is `index` of `12` 
    - The `index` value can change in the response body. So the logic should be to find `index` value for `NAME` (and other fields) and look for it's value at the `index` position in the `data` array
        ```json
        {
            "columns": [
                {
                    "index": 10,
                    "name": "NAME",
                    "fieldName": "name"
                },
                {
                    "index": 12,
                    "name": "LINE",
                    "fieldName": "line"
                }
            ],
            "data": [
                [
                    "row-dyc7~txm7~3t7a",
                    "00000000-0000-0000-FB67-19FB7DFC798D",
                    0.0,
                    1.483630794E9,
                    null,
                    1.483630794E9,
                    null,
                    "{ }",
                    "1734",
                    "http://web.mta.info/nyct/service/",
                    "Birchall Ave & Sagamore St at NW corner", // name
                    "POINT (-73.86835600032798 40.84916900104506)", // coordinates
                    "2-5" // lines
                ],
                ...
            ]   
        }
        ```


### ➠ Download Project
- Download the Git project from [https://gitlab.riproad.com/subway-entrances/subway-entrances-cvansco.git](https://gitlab.riproad.com/subway-entrances/subway-entrances-cvansco.git)
- This project contains one `Activity` — `MainActivity` with a single button on it
- `SubwayEntrances` activity should be launched when user taps on that button


### ➠ Submission Instructions
- Commit & push your changes to the Git project