/**
 * Test simple pipeline in Groovy.
 */
package net.luisalbertogh.pipeline

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import com.lesfurets.jenkins.unit.*

import net.luisalbertogh.jenkins.unit.PipelineTest

/**
 * @author loga
 *
 */
class CyclingStatsPipelineGroovyTest extends PipelineTest {
    /**
     * Set up test.
     */
    @Override
    @Before
    public void setUp() {
        /* Set up */
        super.setUp()

        /* Define variables */
        binding.setVariable('scm', 'scm')
    }

    /**
     * Test execution.
     */
    @Test
    public void runTest() {
        /* Run the script */
        runScript('cycling-stats.pipeline')

        /* Print call stack */
        printCallStack()

        /* Assert step */
        assertTrue(helper.callStack.findAll({call -> call.methodName == "bat"}).any({call -> MethodCall.callArgsToString(call).contains("mvn deploy")}))

        /* Assert job status */
        assertJobStatusSuccess()
    }
}
