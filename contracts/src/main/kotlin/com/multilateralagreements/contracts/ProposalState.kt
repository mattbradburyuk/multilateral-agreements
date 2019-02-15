package com.multilateralagreements.contracts


import net.corda.core.contracts.BelongsToContract
import net.corda.core.contracts.ContractState
import net.corda.core.contracts.StatePointer
import net.corda.core.contracts.StaticPointer
import net.corda.core.crypto.SecureHash
import net.corda.core.identity.AbstractParty
import net.corda.core.identity.Party
import java.time.Instant

// *********
// * State *
// *********

@BelongsToContract(ProposalContract::class)
data class ProposalState(

        val currentStatePointer: StaticPointer<AgreementState>,
        val candidateState: ContractState,
        val expiryTime: Instant,
        val proposer: Party,
        val responders: List<Party>

): ContractState {

    override val participants: List<AbstractParty> = (responders.union(listOf(proposer)).toList())

//    val hashCurrentState = getHashForState(currentState)
//    val hashCandidateState = getHashForState(candidateState)

}


// Is this the right place for this utility
fun getHashForState(state: ContractState): SecureHash.SHA256{
    return SecureHash.sha256( state.toString())
}
