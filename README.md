# CPTGen
Bayesian Network CPT generator code for discrete variables

The example class CPTGen provided here is for a discrete variable of a Bayesian network, which has 2 discrete parents A and B for the child variable C. Parent A has 2 states and parent B has 3 states. Child variable C has 4 states.

The configured constraints are shown below for the solver:

<table>
  <tr>
    <th>A</th>
    <th>B</th>
    <th colspan="4">C</th>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td>4</td>
    <td>3</td>
    <td>2</td>
    <td>1</td>
  </tr>
  <tr>
    <td>1</td>
    <td>1</td>
    <td>&lt;1,1,3</td>
    <td>&lt;1,1,2</td>
    <td>&lt;1,1,1</td>
    <td>Anchor</td>
  </tr>  
  <tr>
    <td>1</td>
    <td>2</td>
    <td>&lt;1,2,3 &nbsp; &gt;1,1,4</td>
    <td>&lt;1,2,2 &nbsp; &gt;1,1,3</td>
    <td>&lt;1,2,1 &nbsp; &gt;1,1,2</td>
    <td>&lt;1,1,1 &nbsp; &gt;1,1,2</td>
  </tr>
  <tr>
    <td>1</td>
    <td>3</td>
    <td>&lt;1,3,3 &nbsp; &gt;1,2,4</td>
    <td>&lt;1,3,2 &nbsp; &gt;1,2,3</td>
    <td>&lt;1,3,1 &nbsp; &gt;1,2,2</td>
    <td>&lt;1,2,1 &nbsp; &gt;1,2,2</td>
  </tr>  
</table>


Example console output:
anchor: P:0.945000 
X112: P:0.023000 
X113: P:0.017000 
X114: P:0.015000 
X121*: P:0.430000 
X122: P:0.224000 
X123: P:0.205000 
X124: P:0.141000 
X131*: P:0.287000 
X132: P:0.286000 
X133: P:0.283000 
X134: P:0.144000 
X211: P:0.361000 
X212: P:0.299000 
X213: P:0.295000 
X214: P:0.045000 
X221: P:0.046000 
anchor2: P:0.945000 
X223: P:0.005000 
X224: P:0.004000 
X231: P:0.424000 
X232: P:0.481000 
X233: P:0.075000 
X234: P:0.020000 
