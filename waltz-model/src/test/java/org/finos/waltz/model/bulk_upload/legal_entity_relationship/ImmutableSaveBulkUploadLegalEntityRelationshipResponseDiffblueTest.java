package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import org.finos.waltz.model.BulkChangeStatistics;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Builder;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableSaveBulkUploadLegalEntityRelationshipResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSaveBulkUploadLegalEntityRelationshipResponseDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAssessmentStats(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAssessmentStats(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAssessmentStats(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAssessmentStats(Iterable)"})
  void testBuilderAddAllAssessmentStats_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentStats(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAssessmentStats(SaveBulkUploadAssessmentStats)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableSaveBulkUploadAssessmentStats.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAssessmentStats(SaveBulkUploadAssessmentStats)}
   */
  @Test
  @DisplayName("Test Builder addAssessmentStats(SaveBulkUploadAssessmentStats) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAssessmentStats(SaveBulkUploadAssessmentStats)"})
  void testBuilderAddAssessmentStatsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAssessmentStats(new ImmutableSaveBulkUploadAssessmentStats.Json()));
  }

  /**
   * Test Builder {@link Builder#addAssessmentStats(SaveBulkUploadAssessmentStats[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableSaveBulkUploadAssessmentStats.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAssessmentStats(SaveBulkUploadAssessmentStats[])}
   */
  @Test
  @DisplayName("Test Builder addAssessmentStats(SaveBulkUploadAssessmentStats[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAssessmentStats(SaveBulkUploadAssessmentStats[])"})
  void testBuilderAddAssessmentStatsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAssessmentStats(new ImmutableSaveBulkUploadAssessmentStats.Json()));
  }

  /**
   * Test Builder {@link Builder#assessmentStats(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#assessmentStats(Iterable)}
   */
  @Test
  @DisplayName("Test Builder assessmentStats(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assessmentStats(Iterable)"})
  void testBuilderAssessmentStats_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentStats(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(SaveBulkUploadLegalEntityRelationshipResponse)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableSaveBulkUploadAssessmentStats.Json} (default constructor).</li>
   *   <li>Then return build assessmentStats size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SaveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  @DisplayName("Test Builder from(SaveBulkUploadLegalEntityRelationshipResponse); given HashSet() add Json (default constructor); then return build assessmentStats size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveBulkUploadLegalEntityRelationshipResponse)"})
  void testBuilderFrom_givenHashSetAddJson_thenReturnBuildAssessmentStatsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();

    HashSet<SaveBulkUploadAssessmentStats> saveBulkUploadAssessmentStatsSet = new HashSet<>();
    saveBulkUploadAssessmentStatsSet.add(new ImmutableSaveBulkUploadAssessmentStats.Json());
    SaveBulkUploadLegalEntityRelationshipResponse instance = mock(SaveBulkUploadLegalEntityRelationshipResponse.class);
    when(instance.assessmentStats()).thenReturn(saveBulkUploadAssessmentStatsSet);
    when(instance.relationshipStats()).thenReturn(mock(BulkChangeStatistics.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentStats();
    verify(instance).relationshipStats();
    assertEquals(1, actualFromResult.build().assessmentStats().size());
    assertEquals(1, builderResult.build().assessmentStats().size());
  }

  /**
   * Test Builder {@link Builder#from(SaveBulkUploadLegalEntityRelationshipResponse)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return build assessmentStats Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SaveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  @DisplayName("Test Builder from(SaveBulkUploadLegalEntityRelationshipResponse); given HashSet(); then return build assessmentStats Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveBulkUploadLegalEntityRelationshipResponse)"})
  void testBuilderFrom_givenHashSet_thenReturnBuildAssessmentStatsEmpty() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();
    SaveBulkUploadLegalEntityRelationshipResponse instance = mock(SaveBulkUploadLegalEntityRelationshipResponse.class);
    when(instance.assessmentStats()).thenReturn(new HashSet<>());
    when(instance.relationshipStats()).thenReturn(mock(BulkChangeStatistics.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentStats();
    verify(instance).relationshipStats();
    assertTrue(actualFromResult.build().assessmentStats().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SaveBulkUploadLegalEntityRelationshipResponse)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SaveBulkUploadLegalEntityRelationshipResponse)}
   */
  @Test
  @DisplayName("Test Builder from(SaveBulkUploadLegalEntityRelationshipResponse); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SaveBulkUploadLegalEntityRelationshipResponse)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();
    SaveBulkUploadLegalEntityRelationshipResponse instance = mock(SaveBulkUploadLegalEntityRelationshipResponse.class);
    when(instance.assessmentStats()).thenThrow(new IllegalStateException("instance"));
    when(instance.relationshipStats()).thenReturn(mock(BulkChangeStatistics.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentStats();
    verify(instance).relationshipStats();
  }

  /**
   * Test Builder {@link Builder#relationshipStats(BulkChangeStatistics)}.
   * <ul>
   *   <li>When {@link BulkChangeStatistics}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#relationshipStats(BulkChangeStatistics)}
   */
  @Test
  @DisplayName("Test Builder relationshipStats(BulkChangeStatistics); when BulkChangeStatistics; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.relationshipStats(BulkChangeStatistics)"})
  void testBuilderRelationshipStats_whenBulkChangeStatistics_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveBulkUploadLegalEntityRelationshipResponse.builder();
    BulkChangeStatistics relationshipStats = mock(BulkChangeStatistics.class);

    // Act and Assert
    assertSame(builderResult, builderResult.relationshipStats(relationshipStats));
    assertSame(relationshipStats, builderResult.build().relationshipStats());
  }

  /**
   * Test Json {@link Json#assessmentStats()}.
   * <p>
   * Method under test: {@link Json#assessmentStats()}
   */
  @Test
  @DisplayName("Test Json assessmentStats()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.assessmentStats()"})
  void testJsonAssessmentStats() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).assessmentStats());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.relationshipStats);
    assertTrue(actualJson.assessmentStats.isEmpty());
  }

  /**
   * Test Json {@link Json#relationshipStats()}.
   * <p>
   * Method under test: {@link Json#relationshipStats()}
   */
  @Test
  @DisplayName("Test Json relationshipStats()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BulkChangeStatistics Json.relationshipStats()"})
  void testJsonRelationshipStats() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).relationshipStats());
  }
}
