# BIDBAX Technical Interview Assignment - Project Tyr

> Týr is a Norse god associated with law, justice, and heroic glory in Norse mythology. He is often depicted as a brave and honorable deity, and he played a role in maintaining order and settling disputes among gods and humans. 

> Týr is also known for his sacrifice, willingly losing his hand to the wolf Fenrir to bind the creature and protect the realms.

While we do not expect you to sacrifice your hand (or anything else!) in doing this assignment - we do hope that you will enjoy working on it!

## About

This repo works as a starting point for your assignment. You will enhance and implement missing pieces of the application.

The assignment is described below, but first you must be able to run the project on your computer locally.

## Requirements

You need to make sure you have installed the following:

* Java 17
* Node.js 20
* git


## Project Structure

This project consists of two applications. 

* A frontend web app built using [Sveltekit](https://kit.svelte.dev/) 
    * The app sources are located in the root of the repository
    * Runs on http://localhost:5173
* The Ecommerce API - a Spring Boot REST API running on 
    * The app sources are located under [./ecommerce-api](./ecommerce-api/)
    * Runs on http://localhost:8080


## Developing

### Web app

Install dependencies for the frontend web app with

```bash
npm install
```

Then you run the dev server with auto-reload:

```bash
npm run dev

# or start the server and open the app in a new browser tab
npm run dev -- --open
```

### REST API

Run the following command (from repository root) to start the REST API with auto-reload:

```bash
./mvnw -f ecommerce-api/pom.xml spring-boot:run
```

## Assignment

Your assigment is split into two parts. 

1. Frontend styling and logic using Svelte and SvelteKit
2. Implementing business logic in the Java Spring Boot REST API

TODO