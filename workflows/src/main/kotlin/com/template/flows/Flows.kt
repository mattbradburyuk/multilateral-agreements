package com.template.flows

import co.paralleluniverse.fibers.Suspendable
import net.corda.core.flows.*
import net.corda.core.utilities.ProgressTracker

// *********
// * Flows *
// *********

object ExampleFlows {
    @InitiatingFlow
    @StartableByRPC
    class Initiator : FlowLogic<Unit>() {
        override val progressTracker = ProgressTracker()

        @Suspendable
        override fun call() {
            // Initiator flow logic goes here.

            logger.info("Initiator.call called")
        }
    }

    @InitiatedBy(Initiator::class)
    class Responder(val counterpartySession: FlowSession) : FlowLogic<Unit>() {
        @Suspendable
        override fun call() {
            // Responder flow logic goes here.
        }
    }
}