# Flix
Flix is an app that allows users to browse movies from the [The Movie Database API](http://docs.themoviedb.apiary.io/#).

---

## Flix

### User Stories


#### REQUIRED (10pts)
- [X] (70pts) User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.
- [X] (10pts) Views should be responsive for both landscape/portrait mode.
   - [X] (5pt) In portrait mode, the poster image, title, and movie overview is shown.
   - [X] (5pt) In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.
- [X] (20pts) Improved the user interface by experimenting with styling and coloring.

### App Walkthough GIF

<img src="https://imgur.com/gallery/LISQZ7Y" width=250><br>

### Notes
Describe any challenges encountered while building the app.
Nested ScrollView unresponsive within a RecyclerView. This change would have made the overview section much better by making the large block of text scrollable.
Some movies do not have backdrop images for landscape mode.

### Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Androids
