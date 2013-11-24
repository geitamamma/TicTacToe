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
		<pre>git clone git@github.com:geitamamma/TicTacToe.git</pre>
	</li>
	<li>