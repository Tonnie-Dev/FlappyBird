package com.androidshowtime.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBird extends ApplicationAdapter {
	SpriteBatch batch;

	//textures in games creations are just image resources
	Texture background;
	Texture []birds;
	int flapState ;

	//gravity variables

	float gravity = 0.2f;
	float velocity = 0;
	int manY = 0;


	//called when the app is run
	@Override
	public void create () {

		//sprite is a collection of textures
		batch = new SpriteBatch();
		background = new Texture("bg.png");
		flapState = 0;
		birds = new Texture[] {new Texture("bird.png"), new Texture("bird2.png")};

	}


	//called continuously in the app
	@Override
	public void render () {
		//add background


		//tells the render method we gonna start displaying sprites
		batch.begin();

		/*display we use batch.draw() - the draw method takes
		* Texture - backgroung
		* X-Co-ordinate - 0
		* Y-Co-Ordinate - 0
		* Width - we get the width from Gdx.graphics Library to match screen size
		* Length - we get the length from Gdx.graphics Library*/


		//draw background
		batch.draw(background, 0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		//flap the bird
		flapTheBird();


		//set the initial Y Position for the bird
		int birdPositionY = Gdx.graphics.getWidth()/2;

		//respond to touch
		if (Gdx.input.isTouched()) {

			Gdx.app.log("Touched", "Bird Touched");
		}

		batch.end();

	}

	private void flapTheBird() {
		//flapState to switch between birds in birds array

		if (flapState ==0) {

			flapState = 1;

		} else {

			flapState = 0;



		}


		try {
//slow the bird flaps
			batch.draw(birds[flapState], (Gdx.graphics.getWidth() / 2f - birds[flapState].getWidth() / 2f),
					   (Gdx.graphics.getHeight() / 2f - birds[flapState].getHeight() / 2f));
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void dispose () {
		batch.dispose();

	}
}
