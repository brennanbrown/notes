<!DOCTYPE html>
<html>
	<head>
	    <link type='text/css' rel='stylesheet' href='style.css'/>
		<title>PHP Testing</title>
	</head>
	<body>
        <h1>
          <?php
          	// Hello World
            echo "Hello," . " " . "world" . "!";
          ?>
        </h1>

        <p>
          <?php
        	  // Standard Variable
	          $myName = "Foobar";
	          echo $myName;
	      	?>
	    </p>

	    <p>
	      <?php
	        // If/Else Statements
		      $items = 4;
		        
		      if($items > 6) {
		    	  echo "You get a 15% discount!";
		      }
		      else {
		    	  echo "You get a 7% discount!";
		      }  
		      ?>
      </p>

      <p>
        <?php
        	// Switch Operator
		      $veg = "Tomato";
		    
		      switch ($veg) {
		        case 'Tomato':
		          echo "Red!";
		          break;
		        
		        default:
		          echo "No vegetables!"
		      }
		    ?>
		  </p>

		  <p>
		  	<?php
		  		// Multiple Cases with Syntatic Sugar
			    $var = 3;
			    
			    switch ($var):
		        case 0:
		          echo 'The variable is zero.';
		          break;
		        case 1:
		        case 2:
		        	echo 'The variable is small.';
		        	break;
		        case 3:
		          echo 'The variable is perfect.';
		          break;
		        case 4:
		        case 5:
		          echo 'The variable is large.';
		          break;
		        default:
		          echo "The variable isn't rational.";
		    	endswitch;
			  ?>
			</p>

			<p>
				<?php
					// Arrays
        	$tens = array(10, 20, 30, 40, 50);
        	echo $tens[2];
        	echo $tens{2};
      	?>
      </p>

      <p>
      	<?php
      		// Modifying Array Elements
	        $languages = array("HTML/CSS",
	        "JavaScript", "PHP", "Python", "Ruby");
	        
	        $languages[1] = "Java";
	        
	        echo $languages[1];
      	?>
    </p>

    <p>
    	<?php
    		// Removing Array Elements
        $languages = array("HTML/CSS",
        "JavaScript", "PHP", "Python", "Ruby");
        
        unset($languages[3]);
        
        foreach($languages as $lang) {
          print "<p>$lang</p>";
        }
      ?>
    </p>

    <p>
	    <?php
	    	// Loops
	      for ($leap = 2004; $leap < 2050; $leap = $leap + 4) {
	        echo "<p>$leap</p>";
	      }
	    ?>
	  </p>

	  <p>
	  	<?php
	  		// 'For' Loops
        // Echoes the first five even numbers
        For ($i = 2; $i < 11; $i = $i + 2) {
          echo $i;
          echo ", "; // Making the output readable
        }
      ?>
	</body>
</html>