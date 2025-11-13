package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.application.ImmutableAppRegistrationResponse.Builder;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AppRegistrationResponseDiffblueTest {
  /**
   * Test {@link AppRegistrationResponse#registered()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AppRegistrationResponse#registered()}
   */
  @Test
  @DisplayName("Test registered(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppRegistrationResponse.registered()"})
  void testRegistered_thenReturnTrue() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");

    // Act and Assert
    assertTrue(
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build()
            .registered());
  }
}
