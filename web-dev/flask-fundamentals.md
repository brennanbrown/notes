# Flask Fundamentals

**Table of Contents:**

- [Flask Fundamentals](#flask-fundamentals)
  - [Configuration](#configuration)
  - [Creating a Flask Project](#creating-a-flask-project)
    - [Jinja Templates](#jinja-templates)
  - [Data and Objects](#data-and-objects)
  - [Database Configuration](#database-configuration)
  - [Web Forms and Security](#web-forms-and-security)
  - [Database Connection](#database-connection)
  - [Data Aggregation](#data-aggregation)
  - [State Management](#state-management)
  - [Deployment on Heroku](#deployment-on-heroku)
    - [Deployment Security](#deployment-security)

## Configuration

- Ensure you have Python3, pip, and venv
  - Self-upgrade pip with `python3 -m pip install --upgrade pip`
- Creation of the project folder
- Creation of the virutal environment using `venv`
  - `python3 -m venv env`
  - `. env/bin/activate`
  - `deactivate` to exit the virtual environment
- Install Flask to virtual enviornment
  - `pip3 install flask`
- Setup enviornment variables
  - `touch .flaskenv` to create the environment variables
  - `pip3 install python-dotenv` will allow enviornment variables to be envoked
- Install the Flask-WTF extension
  - `pip3 install flask-wtf` for web forms within Flask
- Create a `requirements.txt` file for tracking dependencies
  - `pip freeze > requirements.txt`
  - `pip install -r requirements.txt` if installing on a new device/location

## Creating a Flask Project

- Create a `main` module
  - Instaniate a Flask application object
  - Create a default route to display data to the UI
- Run and inspect the application
  - `flask run`
- Creating the project structure
  - Directories for templates, static data, etc.
  - Create an application package `__init__.py`
  - Refactor the `main.py` module
- Running and configuring the development enviornment
  - Create `config.py` and `routes.py`
- Creating the home page of the application
  - Create the template for `index.html`
  - Importating the `render_template` function from the Flask module
  - Usage of the **Jinja** template expression
  - Usage of the `include` directive to include external files
- Creating navigation menus and routing patterns
  - Usage of `url_for` function for resolving links
  - Usage of `route()` decorator to bind a function to one or more URL patterns
    - Eg. `https://domain.com/`, `https://domain.com/index`, `https://domain.com/home`
  - Usage of Jinga delimiters, eg. `{% ... %}` or `{# ... #}`

### Jinja Templates

- Usage of Jinja's inheritance logic
- Creating the base template
  - Using template inheritance to create child templates
- Passing data to the view using props
  - Data from the source to the view
  - Using the `For` directive
  - Building tables with JSON data
- Access data via the request and response objects
  - URL variables
  - HTTP Methods (GET, POST)
  - Global Objects: Request and Response (JSON API Format)

## Data and Objects

**Request Object:**

- Accessing Query String (GET)
  - `request.args.get(<field_name>)`
    - If you put a get function and you get something from the curly string and, if that ID with that token is not there, then you will get a message saying none, so it doesn't crash your site.
  - `request.args[<field_name>]`
    - If you're using the array method, that means you're very specific and assuming you will guarantee that that variable has to be there; if it's not, it'll crash the site, so you don't want that as well.
- Accessing Form Data (POST)
  - `request.form.get(<field_name>)`
  - `request.form[<field_name>]`

**Response Object:**

The Response object is usually used for creating APIs and Flask has this class of response that gives you six parameters that you can use:

```python
class flask.Response(
    # Most commonly used parameters:
    response = None,
    mimetype = None,
    content_type = None,

    status = None,
    headers = None,
    direct_passthrough = False)
```

**URL Variables:**

- Routing patterns (Eg. `domain.com/page/variable`)
- Creating a URL variable
- Setting default data to a URL variable
- Passing a URL variable to a template

**GET Method:**

- Create forms using the GET method
- Create the form template
- Create the form route (URL pattern)
- Accesssing form data via the GET method

**POST Method:**

- Updating the enrollment form using POST method
- Adding the GET and POST methods to route
- Acessing form data using the form object

## Database Configuration

> See: https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/ and https://www.mongodb.com/try/download/compass

- Utilize the MongoDB database system with Flask
  - `sudo systemctl start mongod`
  - `mongodb-compass`
  - `pip install flask-mongoengine`
  - Update `requirements.txt`: `pip freeze > requirements.txt`
- Set up and connect to the new database:
  - Import the newly installed MongoEngine: `From flask_mongoengine import MongoEngine`
  - Set up a MongoDB database: `MONGODB_SETTINGS = { 'db' : 'DATABASE_NAME' }`
  - Initialize the database object: `db = Mongo Engine(); db.init_app(app)`
- Connecting to the database:
  - Connecting to the MongoDB via the MongoEngine object
  - Intergrate a user collection using a user model class
  - Insert sample user document (data) to a collection
  - Display the collection back to the view
- Creating the documents and data:
  - Insert documents within the collections
  - Use of MongoDB shell commands:
    - Create collections (tables): `db.createCollection( <collection> )`
    - Insert an entry into a collection: `db.<collection>.insert( { ... } )`
    - Insert multiple entries into a collection: `db.<collection>.insertMany( {...} )`
  - Insert JSON data using the `mongoexport.exe` via the command line:
    - `mongoimport --db <DB> -collection <collection> --file <file>`
    - Shortcut version: `mongoimport --d <DB> -c <collection> --file <file>`
- Creating the data models:
  - Models for each collection (Eg. User, Courses, Enrollment, etc.)

```python
class ModelName(db.Document):
    field1 = db.IntField()
    field2 = db.StringField()
    # ...
    fieldn = db.StringField()
```

## Web Forms and Security

- Install and configure Flask-WTF and Flask-Security extensions:
  - Flask-WTF is an extension for the WTForms Library
    - WTForms provides a clean way to generate HTML form fields
    - In addition, maintains a separation of code and presentation (similar to MVC)
    - `pip install flask-wtf`
  - Flask-Security provides common security and authentication features:
    - Session-bassed authentication
    - Password hashing
    - Basic HTTP and token-based authentications
    - User registration and login tracking (w/ Flask-Login)
    - Supports data persistency for Flask-SQLAlchemy, Flask-MongoEngine, flask-peewee, and PonyORM
    - `pip install flask-security`

```python
# Example login.html in Jinja:
<form>
    # Generates a CSRF token.
    {{ form.hidden_tag() }}
    {{ form.username }}
    {{ form.email    }}
    {{ form.password }}
</form>

# Example forms.py
class LoginForm(FlaskForm):
    email = StringField('Email')
    password = StringField('Password')
    submit = SubmitField('Login')
```

- Creating the login and registration pages
  - Creation of form classes and updating the templates using the WTForms library
  - Creation of alert messages using the `flash()` method (source)
  - Retrieving flash messages using the `get_flashed_messages()` (view)
  - Validation of forms and displaying error messages
  - Update the login route to capture form data

## Database Connection

- Processing form data and updating the database
  - Processing form data for database updating with validation
  - Update the login and registration route to interact with the database
  - Hash passwords using the **Werkseug** library (A WSGI web app library)
    - `pip install werkzeug`
    - Hashing: `generate_password_hash('password')
    - Unhashing: `check_password_hash(password, 'password')
  - Inserting data and verifying the database using the Compass interface
- Creation of the courses and enrollment pages
  - Querying course data from the database
  - Populate the course template with this data
  - Perform join queries on muliple collections using `$aggregate`.
    - `$lookup`: Performs a left outer join.
    - `$match`: Filters documents.
    - `$unwind`: Deconstructs an array field
- **Important note:** When using an online database, whitelist your IP address.
  - https://docs.atlas.mongodb.com/security-whitelist/

## Data Aggregation

- Usage of the MongoDB aggregation framework using the Compass interface
- Creation of the aggregation pipeline to process data in three stages
  - `$lookup`, `$match`, `$unwind`, `$sort`

**Example Pipeline:**

```js
/**
 * 1. First $lookup Example:
 *
 * from: The target collection.
 * localField: The local join field.
 * foreignField: The target join field.
 * as: The name for the results.
 * pipeline: The pipeline to run on the joined collection.
 * let: Optional variables to use in the pipeline field stages.
 */
{
  from: 'enrollment',
  localField: 'user_id',
  foreignField: 'user_id',
  as: 'result_1'
}
```

```js
/**
 * 2. First $unwind Example:
 *
 * path: Path to the array field.
 * includeArrayIndex: Optional name for index.
 * preserveNullAndEmptyArrays: Optional
 *   toggle to unwind null and empty values.
 */
{
  path: '$result_1',
  includeArrayIndex: 'string',
  preserveNullAndEmptyArrays: false
}
```

```js
/**
 * 3. Second $lookup Example:
 *
 */
{
  from: 'course',
  localField: 'result_1.courseID',
  foreignField: 'courseID',
  as: 'result_2'
}
```

```js
/**
 * 4. Second $unwind Example:
 */
{
  path: '$result_2',
  preserveNullAndEmptyArrays: false
}
```

```js
/**
 * 5. $match Example:
 * query: The query in MQL.
 */
{
  'user_id': user_id
}
```

```js
/**
 * 6. $sort Example:
 * Provide any number of field/order pairs.
 */
{
  "courseID": 1
}
```

## State Management

- Usage of Flask-Session for state management and user authentication
  - The `session` object stores information that's specific to a user
  - Implementation is on top of cookies, and signs cookies crpytographically
  - Creationg of Logout and Enrollment routes with sessions.
- More secure alternative: Flask-Login extension
  - Mangaing user logged-in state using a `user_loader()` function
  - Using the LoginManager class to manage login state
  - Implementing the "remember me" feature
  - Restricting access to protected pages with`@login_required`
  - Logging out users using the `logout_user()` function
  - See more: https://flask-login.readthedocs.io/en/latest/
- Generate secure secret key from command-line:
  - `python3 -c "import os; print(os.urandom(16))"`

```python
# UrlSegment via the Parameters Property:

session['key'] = value # Setting a session
session.get('key')     # Getting a session

session.pop('key', None) # Destroying a session
session['key'] = False   # Destroying a session
```

## Deployment on Heroku

- Flask web frameworks features convenient built-in web servers
  - But these blocking servers only process a single request at a time.
  - If you deploy with one of these servers on Heroku, your dyno resources will be underutilized and your application will feel unresponsive.
- **Gunicorn** is a pure-Python HTTP server for WSGI applications.
  - It allows you to run any Python application concurrently by running multiple Python processes within a single dyno.
  - It provides a perfect balance of performance, flexibility, and configuration simplicity.
  - `pip install gunicorn`
- Create an app on Heroku, which prepares Heroku to receive your source code: `heroku create`
  - Deploy your code: `git push heroku master`
  - Ensure that at least one instance of the app is running: `heroku ps:scale web=1`
  - Visit the app at the URL generated by its app name. As a handy shortcut, you can open the website as follows: `heroku open`
  - View information about your running app using one of the logging commands: `heroku logs --tail`
- Use a Procfile, a text file in the root directory of your application, to explicitly declare what command should be executed to start your app.
  - The Procfile in the example app you deployed looks like this: `web: gunicorn app:app`
  - Use the default Procfile by running: `heroku local web`
- Reinstall your requirements: `pip install -r requirements.txt`

### Deployment Security

For database security, in `app.json`, add the following:

```json
  "env": {
    "MONGO_URI": {
      "description": "The URI to connect to the MongoDB.",
      "value": "mongodb://localhost:27017/FLASK_Enrollment"
    },
```

As well as modifying `config.py`:

```python
    MONGODB_SETTINGS = { "db" : "FLASK_Enrollment",
        "host" : os.environ.get("MONGO_URI")
    }
```

Afterwards, you can modify the `value` of `MONGO_URI` directly within the settings of Heroku. This prevents the password of the MongoDB admin from being revealed.

Of course, also make sure your virtual environment folder, `env`, is also in your `.gitignore`.
