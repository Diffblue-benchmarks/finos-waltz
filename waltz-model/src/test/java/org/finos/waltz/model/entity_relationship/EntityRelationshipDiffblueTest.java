package org.finos.waltz.model.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationship.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityRelationshipDiffblueTest {
  /**
   * Test {@link EntityRelationship#toKey()}.
   *
   * <ul>
   *   <li>Then a return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationship#toKey()}
   */
  @Test
  @DisplayName("Test toKey(); then a return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelationshipKey EntityRelationship.toKey()"})
  void testToKey_thenAReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    EntityRelationshipKey actualToKeyResult =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build()
            .toKey();

    // Assert
    EntityReference aResult2 = actualToKeyResult.a();
    assertTrue(aResult2 instanceof ImmutableEntityReference);
    EntityReference bResult = actualToKeyResult.b();
    assertTrue(bResult instanceof ImmutableEntityReference);
    assertTrue(actualToKeyResult instanceof ImmutableEntityRelationshipKey);
    assertEquals("The characteristics of someone or something", aResult2.description());
    assertEquals(1L, aResult2.id());
    assertEquals(EntityKind.ALL, aResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, aResult2.entityLifecycleStatus());
    assertEquals(aResult2, bResult);
  }
}
