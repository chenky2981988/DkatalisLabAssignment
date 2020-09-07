# DkatalisLabAssignment
Tinder like swipe View, Room DB, Retrofit, Kotlin, MVVM

App Name : Random People Carousel

Purpose of this application is submit assignment for Dkatalis Lab, Pune

User case:
* Load random user from cloud API
* User can see User Card on screen
* User can swipe left and right to card to accept and reject of random user
* Swipe left will reject user and load another user
* Swipe right will add random user to favourite list and load new user
* User can see favourite people list
* User can see favourite people details by clicking on them

Source code details:
* Source coe contains MVVM architecture with basic oops concept
* Unit test cases for few files
* UI Test cases for MainActivity
* Room Database to store favourite People list
* Coroutine to load data from RandomPeople API and store favourite people
* ViewMode with LiveData

Third Party libraries:
* Retrofit - Networking Library (https://square.github.io/retrofit/)
* PlaceHolderView - Tinder like swipe card (https://github.com/janishar/PlaceHolderView)
* ButterKnifelite - Supporting library for PlaceHolderView to view binding (https://github.com/janishar/ButterKnifeLite)
* Mockito - Mocking object for Unit test cases (https://site.mockito.org/)
* Glide - To load image from cloud and image caching (https://github.com/bumptech/glide)
* CircleImageView - To display image in circular form (https://github.com/hdodenhof/CircleImageView)
