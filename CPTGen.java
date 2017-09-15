/*
Copyright (c) 2017, IMT Atlantique
All rights reserved.

THIS SOFTWARE IS PROVIDED BY IMT Atlantique ''AS IS'' AND ANY
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL IMT Atlantique BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.search.loop.monitors.IMonitorSolution;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.search.strategy.assignments.DecisionOperator;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.util.tools.ArrayUtils;
import org.chocosolver.solver.Solution;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CPTGen {
    public void modelAndSolve() {
        Model model = new Model("Generate CPT row");
        
        // define the constraint variables
        IntVar varAnchor = model.intVar("anchor",945);
        IntVar varX112 = CreateCPTVariable(model,"X112");
        IntVar varX113 = CreateCPTVariable(model,"X113");
        IntVar varX114 = CreateCPTVariable(model,"X114");
        IntVar varX121 = CreateCPTVariable(model,"X121*");
        IntVar varX122 = CreateCPTVariable(model,"X122");
        IntVar varX123 = CreateCPTVariable(model,"X123");
        IntVar varX124 = CreateCPTVariable(model,"X124");
        IntVar varX131 = CreateCPTVariable(model,"X131*");
        IntVar varX132 = CreateCPTVariable(model,"X132");
        IntVar varX133 = CreateCPTVariable(model,"X133");
        IntVar varX134 = CreateCPTVariable(model,"X134");

        IntVar varX211 = CreateCPTVariable(model,"X211");
        IntVar varX212 = CreateCPTVariable(model,"X212*");
        IntVar varX213 = CreateCPTVariable(model,"X213");
        IntVar varX214 = CreateCPTVariable(model,"X214");
        IntVar varX221 = CreateCPTVariable(model,"X221");
        IntVar varAnchor2 = model.intVar("anchor2",945);
        IntVar varX223 = CreateCPTVariable(model,"X223");
        IntVar varX224 = CreateCPTVariable(model,"X224");        
        IntVar varX231 = CreateCPTVariable(model,"X231");
        IntVar varX232 = CreateCPTVariable(model,"X232*");
        IntVar varX233 = CreateCPTVariable(model,"X233");
        IntVar varX234 = CreateCPTVariable(model,"X234");


        IntVar[] vars = { 
            varAnchor, 
            varX112,
            varX113,
            varX114,
            varX121,
            varX122,
            varX123,
            varX124,
            varX131,
            varX132,
            varX133,
            varX134,
            varX211,
            varX212,
            varX213,
            varX214,
            varX221,
            varAnchor2,
            varX223,
            varX224,
            varX231,
            varX232,
            varX233,
            varX234            
        };
        
        IntVar[] row1 = Arrays.copyOfRange(vars, 0, 4);
        IntVar[] row2 = Arrays.copyOfRange(vars, 4, 8);
        IntVar[] row3 = Arrays.copyOfRange(vars, 8, 12);
        IntVar[] row4 = Arrays.copyOfRange(vars, 12, 16);
        IntVar[] row5 = Arrays.copyOfRange(vars, 16, 20);
        IntVar[] row6 = Arrays.copyOfRange(vars, 20, 24);
        
        // define the constraints
        model.post(model.sum(row1, "=", 1000)); // the row must sum to 1000
        model.post(model.sum(row2, "=", 1000)); // the row must sum to 1000
        model.post(model.sum(row3, "=", 1000)); // the row must sum to 1000
        model.post(model.sum(row4, "=", 1000)); // the row must sum to 1000
        model.post(model.sum(row5, "=", 1000)); // the row must sum to 1000
        model.post(model.sum(row6, "=", 1000)); // the row must sum to 1000        
        model.post(model.arithm(varX112, "<", varAnchor));
        model.post(model.arithm(varX113, "<", varX112));
        model.post(model.arithm(varX114, "<", varX113));

        model.post(model.arithm(varX121, "<", varAnchor));
        model.post(model.arithm(varX121, ">", varX112));

        model.post(model.arithm(varX122, "<", varX121));
        model.post(model.arithm(varX122, ">", varX112));

        model.post(model.arithm(varX123, "<", varX122));
        model.post(model.arithm(varX123, ">", varX113));
        
        model.post(model.arithm(varX124, "<", varX123));
        model.post(model.arithm(varX124, ">", varX114));
        //
        model.post(model.arithm(varX131, "<", varX121));
        model.post(model.arithm(varX131, ">", varX122));

        model.post(model.arithm(varX132, "<", varX131));
        model.post(model.arithm(varX132, ">", varX122));

        model.post(model.arithm(varX133, "<", varX132));
        model.post(model.arithm(varX133, ">", varX123));
        
        model.post(model.arithm(varX134, "<", varX133));
        model.post(model.arithm(varX134, ">", varX124));
        //
        model.post(model.arithm(varX223, "<", varAnchor2));
        model.post(model.arithm(varX224, "<", varX223));
        model.post(model.arithm(varX221, ">", varX223));

        model.post(model.arithm(varX212, "<", varX232));
        model.post(model.arithm(varX213, "<", varX212));
        model.post(model.arithm(varX213, ">", varX233));
        model.post(model.arithm(varX214, "<", varX213));
        model.post(model.arithm(varX214, ">", varX234));
        model.post(model.arithm(varX211, ">", varX213));


        model.post(model.arithm(varX232, "<", varAnchor2));
        model.post(model.arithm(varX233, "<", varX232));
        model.post(model.arithm(varX233, ">", varX223));
        model.post(model.arithm(varX234, "<", varX233));
        model.post(model.arithm(varX234, ">", varX224));
        model.post(model.arithm(varX231, ">", varX233));

        // find a solution
        Solver solver = this.CreateSolver(model, vars);
        Solution solution = solver.findSolution();
        
        // output the results
        for (IntVar i : vars) {
            System.out.printf("%s: P:%f %n", i.getName(), FormatProbability(i.getValue()));
        }
    }
    
    private static IntVar CreateCPTVariable(Model model, String name) {
        return model.intVar(name,1,999);
    }
    
    private Solver CreateSolver(Model model, IntVar[] vars) {
        long millis = System.currentTimeMillis() % 1000; // random domain value selector seed       
        
        // create and configure the solver
        Solver solver = model.getSolver();
        // set the domain value selector to random
        solver.setSearch(Search.randomSearch(vars,millis));
        
        return solver;
    }
    
    private static double FormatProbability(int value) {
        return ((double)value) / ((double)1000);
    }
    
    public static void main(String[] args) {
        new CPTGen().modelAndSolve();
    }
}