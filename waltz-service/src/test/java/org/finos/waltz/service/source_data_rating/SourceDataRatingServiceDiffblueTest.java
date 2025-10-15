package org.finos.waltz.service.source_data_rating;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.data.source_data_rating.SourceDataRatingDao;
import org.finos.waltz.model.source_data_rating.SourceDataRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SourceDataRatingServiceDiffblueTest {
  @Mock private SourceDataRatingDao sourceDataRatingDao;

  @InjectMocks private SourceDataRatingService sourceDataRatingService;

  /**
   * Test {@link SourceDataRatingService#findAll()}.
   *
   * <p>Method under test: {@link SourceDataRatingService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SourceDataRatingService.findAll()"})
  void testFindAll() {
    // Arrange
    ArrayList<SourceDataRating> sourceDataRatingList = new ArrayList<>();
    when(sourceDataRatingDao.findAll()).thenReturn(sourceDataRatingList);

    // Act
    Collection<SourceDataRating> actualFindAllResult = sourceDataRatingService.findAll();

    // Assert
    verify(sourceDataRatingDao).findAll();
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(sourceDataRatingList, actualFindAllResult);
  }
}
