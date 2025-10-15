package org.finos.waltz.model.bulk_upload.taxonomy;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkTaxonomyItemDiffblueTest {
  /**
   * Test {@link BulkTaxonomyItem#concrete()}.
   *
   * <p>Method under test: {@link BulkTaxonomyItem#concrete()}
   */
  @Test
  @DisplayName("Test concrete()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkTaxonomyItem.concrete()"})
  void testConcrete() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableBulkTaxonomyItem.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .parentExternalId("42")
            .build()
            .concrete());
  }
}
