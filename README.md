# Veriff connector
Mendix integration with [Veriff](https://veriff.com/). Veriff is a KYC, AML and identity verification platform. 

## Setup
You need to ask for an account on [Veriff](https://veriff.com/), and set the API key in the ``Config`` entity.

## Local tests
* Veriff doesn't currently allow non-https urls for callbacks (a feature request has been submitted) ; so you'll need to set your callback like "https://localhost ...", and switch to http in the browser manually
* For your webhooks, you should probably configure RequestCatcher, and then re-post the callbacks to your local server using Postman

## API documentation
API documentation of Veriff is [here](https://developers.veriff.com/).

## Mendix version
9+