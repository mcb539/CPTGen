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
