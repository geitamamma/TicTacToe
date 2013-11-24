<h1>Administration Manual</h1>

The following programs are needed to run this program
<pre>
	Git
	Java JDK 7 
	Maven
</pre>

<h2>Setting up the environment</h2>
<ol>
	<li>Install and set up Git, go to <a href="https://help.github.com/articles/set-up-git">https://help.github.com/articles/set-up-git</a> for instructions</li>

	<li>Install and set up Java, go to <a href="http://www.java.com/en/download/help/windows_manual_download.xml">http://www.java.com/en/download/help/windows_manual_download.xml</a> for instructions</li>

	<li>Install and set up Maven, go to <a href="http://www.mkyong.com/maven/how-to-install-maven-in-windows/">http://www.mkyong.com/maven/how-to-install-maven-in-windows/</a> for instructions
	</li>

	<li>Install Travis
		<pre>
			sudo apt-get install -y make ruby1.9.1-dev
			sudo gem1.9.1 install travis</pre>
	</li>

	<li>Install Heroku
		<pre>
			wget -qO- https://toolbelt.heroku.com/install-ubuntu.sh | sh</pre>
	</li>
</ol>
<ul>
	<li>Fork this repository</li>
	<li>Clone the project to your computer, run this command:
		<pre>git clone git@github.com:[Your_Username]/[ProjectName].git</pre>
	</li>
	<li>Go to <a href="https://travis-ci.org/">https://travis-ci.org/</a> and create an account</li>
	<li>
	<li>Go to <a href="https://www.heroku.com/">https://www.heroku.com/</a> and create an account</li>
</ul>

<h2>Deploy and Maintain<h2>
<ul>
	<li>To set the heroku key for travis run the following commands
		<pre>
			travis setup heroku
			travis encrypt HEROKU_API_KEY=<your_heroku_key> --add</pre>
	</li>
	<li>Connect your Travis account with Github</li>
	<li>Use Heroku toolbelt to create an app <pre>heroku create</pre></li>
	<li>Create on app as staging server and one app as production server</li>
	<li>You will need to change the .travis.yml file according to the heroku apps you just created
		<pre>
			app: geitamamma-production  --> app: [yourAppName]
			repo: geitamamma/TicTacToe  --> repo: [yourRepository]
			- export STAGING_SERVER=http://geitamamma-staging.herokuapp.com/  --> - export STAGING_SERVER=http://[yourAppName].herokuapp.com/</pre>
	</li>
</ul>

<p>Now you can make some changes to the repository and push them to github and after the project has passed all test it should be up and running on your heroku apps at http://[yourHerokuAppName].herokuapp.com/<p>